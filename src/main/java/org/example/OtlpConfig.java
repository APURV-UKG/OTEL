package org.example;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
//this configuration class defines a bean of type OtlpHttpSpanExporter
//that is responsible for exporting trace data to
//an OpenTelemetry Protocol (OTLP) endpoint. The endpoint URL
//is obtained from the application's configuration
@Configuration
public class OtlpConfig {
    //yaha neeche @value k anadar ka link application.yml se aarha h
    //ye bhi neeeche bean create krrha h otlpHttpSpanExporter jo ki ek
    //object h jo facilitate krega exchange of traces
    @Bean
    OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
        return OtlpHttpSpanExporter.builder()
                .setEndpoint(url)
                .build();
    }
}