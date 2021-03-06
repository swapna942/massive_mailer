package com.odde.massivemailer.model;

import com.odde.massivemailer.model.validator.UniquenessValidator;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.*;

/**
 * Created by csd on 30/5/17.
 */
@Table("courses")
public class Course extends Model {

    private String coursename;
    private String duration;
    private String location;
    private Date startdate;
    private String address;
    private String coursedetails;
    private String instructor;


    public Course(CourseBuilder courseBuilder) {


        this.coursename = courseBuilder.coursename;
        this.duration= courseBuilder.duration;
        this.location= courseBuilder.location;
        this.startdate= courseBuilder.startdate;
        this.address= courseBuilder.address;
        this.coursedetails= courseBuilder.coursedetails;
        this.instructor= courseBuilder.instructor;

    }

    /*public Course(String coursename, String duration, String location, Date startdate, String address, String coursedetails, String instructor) {
        setCoursename(coursename);
        setDuration(duration);
        setLocation(location);
        setStartdate(startdate);
        setAddress(address);
        setCoursedetails(coursedetails);
        setInstructor(instructor);
    }*/

    public String getCoursename() {
        return coursename;
    }

    public String getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public Date getStartdate() {
        return startdate;
    }

    public String getAddress() {
        return address;
    }

    public String getCoursedetails() {
        return coursedetails;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCoursedetails(String coursedetails) {
        this.coursedetails = coursedetails;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public static class CourseBuilder {

        private String coursename;
        private String duration;
        private String location;
        private Date startdate;
        private String address;
        private String coursedetails;
        private String instructor;

        public CourseBuilder setCoursename(String coursename) {
            this.coursename = coursename;
            return this;
        }

        public CourseBuilder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public CourseBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public CourseBuilder setStartdate(Date startdate) {
            this.startdate = startdate;
            return this;
        }

        public CourseBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CourseBuilder setCoursedetails(String coursedetails) {
            this.coursedetails = coursedetails;
            return this;
        }

        public CourseBuilder setInstructor(String instructor) {
            this.instructor = instructor;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }
}
