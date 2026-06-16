package com.dto;

public class AppointmentRequest {
    private String date;
    private String time;
    private Integer doctorId;
    private Integer patientId;

    // Constructors (Optional)
    public AppointmentRequest() {}
    
    public AppointmentRequest(String date, String time, Integer doctorId, Integer patientId) {
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    // toString for debug logging
    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
