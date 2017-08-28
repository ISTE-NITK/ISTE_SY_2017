package com.nitk.iste.scotlandyard;



public class AppointmentItemStub {

    public boolean isSpacer = false;
    public boolean isEmptyPlaceholder = false;

    String DoctorID;
    String DoctorName;
    String AppointmentDate;
    String AppointmentDay;
    String AppointmentTime;


    public AppointmentItemStub()
    {
    }

    public AppointmentItemStub(String DoctorID,
            String DoctorName,
            String AppointmentDate,
            String AppointmentDay,
            String AppointmentTime)
    {
        this.DoctorID=DoctorID;
        this.DoctorName=DoctorName;
        this.AppointmentDate=AppointmentDate;
        this.AppointmentDay=AppointmentDay;
        this.AppointmentTime=AppointmentTime;

    }

}
