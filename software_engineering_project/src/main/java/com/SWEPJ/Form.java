package com.SWEPJ;

//PID = pid of requester
//DOB = date of birth of the requester
//name fields = name of the requester
//email = email of the requester
//relation = requesters relation to the dead
//DOD = date of relative death
//relatedPID = the relatives pid
//fid = id to look form up with
//fail = [PID, DOB, relation, firstname, middlename, lastname, email, relatedPID, DOD] * FID is managed internally by database manager and does not need checked here
public class Form {
    private Boolean fail[];
    private long PID, relatedPID, FID;
    private String DOB, DOD, firstName, middleName, lastName, email, relation;

    public Form(long PID, String DOB, String DOD, String relation, String firstName, String middleName,
            String lastName, String email, long relatedPID) {
        this.PID = PID;
        this.DOB = DOB;
        this.DOD = DOD;
        this.relation = relation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.relatedPID = relatedPID;
        this.FID = -1;
        fail = new Boolean[9];
        for (int i = 0; i < 9; i++)
            fail[i] = false; // PID DOB relation firstName middleName lastName email
        isValid();// Will require user classes to manually check fail[] array
    }

    public String getDOD() {
        return DOD;
    }

    public long getRelatedPID() {
        return relatedPID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public long getPID() {
        return PID;
    }

    public String getRelation() {
        return relation;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public long getFID() {
        return FID;
    }

    public Boolean[] getFail() {
        return fail;
    }

    public void setFID(long FID) {
        this.FID = FID;
    }

    public Boolean setDOB(String DOB) {
        this.DOB = DOB;
        fail[1] = false;
        this.isValid();
        if (!fail[1])
            return true;
        // this.DOB = temp;
        return false;
    }

    public Boolean setFirstName(String firstName) {
        this.firstName = firstName;
        fail[3] = false;
        this.isValid();
        if (!fail[3])
            return true;
        // this.firstName = temp;
        return false;
    }

    public Boolean setLastName(String lastName) {
        this.lastName = lastName;
        fail[5] = false;
        this.isValid();
        if (!fail[5])
            return true;
        // this.lastName = temp;
        return false;
    }

    public Boolean setDOD(String DOD) {
        this.DOD = DOD;
        fail[8] = false;
        this.isValid();
        if (!fail[8])
            return true;
        // this.DOD = temp;
        return false;
    }

    public Boolean setMiddleName(String middleName) {
        this.middleName = middleName;
        fail[4] = false;
        this.isValid();
        if (!fail[4])
            return true;
        // this.middleName = temp;
        return false;
    }

    public Boolean setPID(long PID) {
        // long temp = this.PID;
        this.PID = PID;
        fail[0] = false;
        this.isValid();
        if (!fail[0])
            return true;
        // this.PID = temp;
        return false;
    }

    public Boolean setRelatedPID(long relatedPID) {
        // long temp = this.relatedPID;
        this.relatedPID = relatedPID;
        fail[7] = false;
        this.isValid();
        if (!fail[7])
            return true;
        // this.relatedPID = temp;
        return false;
    }

    public Boolean setRelation(String relation) {
        // String temp = this.relation;
        this.relation = relation;
        fail[2] = false;
        this.isValid();
        if (!fail[2])
            return true;
        // this.relation = temp;
        return false;
    }

    public boolean setEmail(String email) {
        // String temp = this.email;
        this.email = email;
        fail[6] = false;
        this.isValid();
        if (!fail[6])
            return true;
        // this.email = temp;
        return false;
    }

    public Boolean isValid() {
        // reset fail array
        // for (int i = 0; i < 9; i++)
        // fail[i] = false;

        // checks for PID
        if (String.valueOf(PID).length() != 9) {
            fail[0] = true;
        }

        if (String.valueOf(relatedPID).length() != 9) {
            fail[7] = true;
        }

        // checks for DOB
        try {
            String[] birthdate = DOB.split("/", 3);
            int month = Integer.parseInt(birthdate[0]);
            int day = Integer.parseInt(birthdate[1]);
            int year = Integer.parseInt(birthdate[2]);

            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day > 31 || day < 1)
                        fail[1] = true;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30 || day < 1)
                        fail[1] = true;
                    break;
                case 2:
                    if (year % 4 == 0) {
                        if (day > 29 || day < 1)
                            fail[1] = true;
                    } else {
                        if (day > 28 || day < 1)
                            fail[1] = true;
                    }
                    break;
                default:
                    fail[1] = true;
                    break;
            }
            if (year < 1900 || year > 2024)
                fail[1] = true;

        } catch (Exception e) {
            fail[1] = true;
        }

        // checks for relation
        if (relation.length() > 35 || relation.length() < 1)
            fail[2] = true;
        if (relation.indexOf(' ') != -1)
            fail[2] = true;
        // checks for firstName
        if (firstName.length() > 35 || firstName.length() < 1)
            fail[3] = true;

        // checks for middleName
        if (middleName.length() > 35)
            fail[4] = true;

        // checks for lastName
        if (lastName.length() > 35 || lastName.length() < 1)
            fail[5] = true;
        // check death date
        try {
            String[] deathdate = DOD.split("/", 3);
            int dMonth = Integer.parseInt(deathdate[0]);
            int dDay = Integer.parseInt(deathdate[1]);
            int dYear = Integer.parseInt(deathdate[2]);

            switch (dMonth) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dDay > 31 || dDay < 1)
                        fail[8] = true;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dDay > 30 || dDay < 1)
                        fail[8] = true;
                    break;
                case 2:
                    if (dYear % 4 == 0) {
                        if (dDay > 29 || dDay < 1)
                            fail[8] = true;
                    } else {
                        if (dDay > 28 || dDay < 1)
                            fail[8] = true;
                    }
                    break;
                default:
                    fail[8] = true;
                    break;
            }
            if (dYear < 1900 || dYear > 2024)
                fail[8] = true;

        } catch (Exception e) {
            fail[8] = true;
        }
        // check email
        if (email.length() > 105 || email.length() < 5) {
            fail[6] = true;
        }
        try {
            String[] tester = email.split("@");
            if (tester[1].indexOf('.') == -1) {
                fail[6] = true;
            }
        } catch (Exception e) {
            fail[6] = true;
        }
        // check if any field failed
        for (int i = 0; i < 9; i++) {
            if (fail[i] == true)
                return false;
        }
        return true;
    }

}
