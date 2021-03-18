package com.sample.company.employeeservices.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class GetEmployeeDetailServiceRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        configureGetEmployeeDetailPaymentRoute();
    }

    private void configureGetEmployeeDetailPaymentRoute() {
        final String getEmployeeDetailProcessor = "getEmployeeDetailProcessor";

        from("cxf:bean:cXFGetEmployeeDetailHttp")
                .id("httpGetEmployeeDetailRoute")
                .to(getEmployeeDetailProcessor)
        ;

    }

}