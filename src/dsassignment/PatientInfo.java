package dsassignment;

public class PatientInfo {

    private String patientName;
    private int patientID;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Id: " + patientID + " Name: " + patientName;
    }

}
