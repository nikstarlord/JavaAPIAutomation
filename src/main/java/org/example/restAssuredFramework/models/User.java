package org.example.restAssuredFramework.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public int id;
    public String name;
    public String userName;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address{
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;

        @JsonProperty("street")
        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @JsonProperty("suite")
        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @JsonProperty("zipcode")
        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        @JsonProperty("geo")
        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Geo{
            public double latitude;
            public double longitude;

            @JsonProperty("lat")
            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            @JsonProperty("lng")
            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Company{
        public String name;
        public String catchPhrase;
        public String bs;

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("catchPhrase")
        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        @JsonProperty("bs")
        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }
    }
}
