package com.algaworks.algasensors.device.management;

import com.algaworks.algasensors.device.management.common.IdGenerator;
import io.hypersistence.tsid.TSID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TSIDTest {

    @Test
    public void shouldGenerateTSID() {
        // Método não ideal, pois não considera valores do system
        TSID tsid = TSID.fast();

        System.out.println(tsid);
        System.out.println(tsid.toLong());
        System.out.println(tsid.getInstant());
    }

    @Test
    public void shouldGenerateTSIDWithParameters() {
        // Dessa forma o Factory irá considerar os parametros de ambiente para geração do TSID
        System.setProperty("tsid.node", "7");
        System.setProperty("tsid.node.count", "32");

        TSID.Factory factory = TSID.Factory.builder().build();
        TSID tsid = factory.generate();

        System.out.println(tsid);
        System.out.println(tsid.toLong());
        System.out.println(tsid.getInstant());
    }

    @Test
    public void shouldGenerateTSIDWithGenerator() {
        TSID tsid = IdGenerator.generateTSID();

        System.out.println(tsid);
        System.out.println(tsid.toLong());
        System.out.println(tsid.getInstant());

        Assertions.assertThat(tsid.getInstant())
                .isCloseTo(Instant.now(), Assertions.within(1, ChronoUnit.MINUTES));
    }
}
