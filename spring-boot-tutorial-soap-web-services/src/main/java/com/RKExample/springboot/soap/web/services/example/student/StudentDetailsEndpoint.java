package com.RKExample.springboot.soap.web.services.example.student;


import com.RKExample.students.GetStudentDetailsRequest;
import com.RKExample.students.GetStudentDetailsResponse;
import com.RKExample.students.StudentDetails;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class StudentDetailsEndpoint {
@PayloadRoot(namespace = "http://RKExample.com/students",localPart = "GetStudentDetailsRequest")
   @ResponsePayload
    public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request){
        GetStudentDetailsResponse getStudentDetailsResponse = new GetStudentDetailsResponse();
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(request.getId());
        studentDetails.setName("Adam");
        studentDetails.setPassportNumber("E123456");
        getStudentDetailsResponse.setStudentDetails(studentDetails);
        return getStudentDetailsResponse;
    }
}
