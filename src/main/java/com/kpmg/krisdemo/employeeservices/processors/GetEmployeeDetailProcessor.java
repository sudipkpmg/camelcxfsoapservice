package com.kpmg.krisdemo.employeeservices.processors;

import com.kpmg.krisdemo.employeeservice.getemployeedetailservice.getemployeedetailrequest.GetEmployeeDetailRequest;
import com.kpmg.krisdemo.employeeservice.getemployeedetailservice.getemployeedetailresponse.Body;
import com.kpmg.krisdemo.employeeservice.getemployeedetailservice.getemployeedetailresponse.GetEmployeeDetailResponse;
import com.kpmg.krisdemo.employeeservice.getemployeedetailservice.getemployeedetailresponse.ObjectFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("getEmployeeDetailProcessor")
public class GetEmployeeDetailProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(GetEmployeeDetailProcessor.class.getName());
    
    @Override
    public void process(Exchange exchange) throws Exception {
    	
        @SuppressWarnings("unchecked")
        GetEmployeeDetailRequest request = exchange.getIn().getBody(GetEmployeeDetailRequest.class);
        GetEmployeeDetailResponse response = getGetEmployeeDetailResponse(request);      
        exchange.getOut().setBody(response);
    }
    
    private GetEmployeeDetailResponse getGetEmployeeDetailResponse(GetEmployeeDetailRequest request) {
    	GetEmployeeDetailResponse response = new ObjectFactory().createGetEmployeeDetailResponse();
    	Body body = new ObjectFactory().createBody();
    	if (request != null && request.getBody() != null && "1".equals(request.getBody().getEmployeeID())) {
	    	body.setEmployeeName("Bill Gates");
	    	body.setEmployeeID("1");
	    	body.setEmployeeEmail("bill@microsoft.com");
    	} else {
	    	body.setEmployeeName("Jeff Bezos");
	    	body.setEmployeeID("2");
	    	body.setEmployeeEmail("jeff_bezos@amazon.com");
    	}
    	
    	response.setBody(body);
    	return response;
    }
}