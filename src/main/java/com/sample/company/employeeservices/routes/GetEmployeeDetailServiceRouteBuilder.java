package com.sample.company.employeeservices.routes;

import org.springframework.stereotype.Service;

/**
 * The Class GetEmployeeDetailServiceRouteBuilder.
 */
@Service
public class GetEmployeeDetailServiceRouteBuilder extends EmployeeServicesGenericRouteBuilder {

    @Override
    public void configure() throws Exception {
        super.configure();
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