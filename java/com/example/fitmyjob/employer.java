package com.example.fitmyjob;

public class employer
{
    private String editename;
    private String editposition;
    private String editpcity;
    private String edob;
    private String editecountry;
    private String editdocumentid;

    employer()
    {

    }

    private employer(String ename, String position, String pcity, String ecountry,String dob, String documentid)
    {
        this.editename=ename;
        this.editposition=position;
        this.editpcity=pcity;
        this.edob=ecountry;
        this.editecountry=dob;
        this.editdocumentid = documentid;

    }

    String getEditename() {
        return editename;
    }

    public void setEditname(String editename) {
        this.editename = editename;
    }

    String getEditposition() {
        return editposition;
    }

    public void setEditposition(String editpcity) {
        this.editposition = editposition;
    }

    String getEditpcity() {
        return editpcity;
    }

    public void setEditpcity(String editpcity) {
        this.editpcity = editpcity;
    }

    String getEdob() {
        return edob;
    }

    public void setEdob(String edob) {
        this.edob = edob;
    }
    String getEditecountry() {
        return editecountry;
    }

    public void setEditecountry(String editecountry) {
        this.editecountry = editecountry;
    }


    String getEditdocumentid() {
        return editdocumentid;
    }

    void setEditdocumentid(String editdocumentid) {
        this.editdocumentid = editdocumentid;
    }
}