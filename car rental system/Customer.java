public class Customer {
    private int customerId;
    private String name;
    private String contactInfo;
    private String address;
    private String driverLicenseNumber;

    public Customer(int customerId, String name, String contactInfo, String address, String driverLicenseNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
