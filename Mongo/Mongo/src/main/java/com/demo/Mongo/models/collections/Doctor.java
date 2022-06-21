package com.demo.Mongo.models.collections;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("doctor")
public class Doctor {
    @Id
    private String _id;
    private Name name;
    private String phone;
    private String gender;
    private List<String> specializations;

    public Doctor() {
    }

    public Doctor(Name name, String phone, String gender, List<String> specializations) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.specializations = specializations;
    }

    public Doctor(String _id, Name name, String phone, String gender, List<String> specializations) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.specializations = specializations;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<String> specializations) {
        this.specializations = specializations;
    }
}
