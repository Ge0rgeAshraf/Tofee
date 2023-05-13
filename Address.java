package Shipping;

public class Address
{
    public String government;
    public String district;
    public String street;
    public int floorNO;
    public String landMark;
    public Address(String gov,String dis,String str,int fNO,String LMark)
    {
        this.government = gov;
        this.district = dis;
        this.street = str;
        this.floorNO = fNO;
        this.landMark = LMark;
    }

    @Override
    public String toString() {
        return "Land Mark: " + this.landMark + " **Floor Number: " + this.floorNO + " **Street Name: " + this.street + " **District: " + this.district + " **Government: " + this.government;
    }
}
