package com.algaworks.algasensors.device.management.api.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorDetailOutput {
    private SensorOutput sensor;
    private SensorMonitoringOutput monitoring;
}
