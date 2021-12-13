package edu.neu.csye7374.Observer;

import edu.neu.csye7374.Personnel.Employee;
import edu.neu.csye7374.Personnel.Personnel;

import java.util.ArrayList;
import java.util.List;

public class AnnualReview implements Observer{
    private String date;

    public AnnualReview(){
        date = "1970-01-01";
    }

    @Override
    public void update(String date) {
        this.date = date;
    }

    /**
     * Get the employees that should be under annual review.
	 * It will alart all the employee that is approaching the hire date (within 1 mounth, neglect year)
	 * For example, if the hire date is 2020-12-31, it will alert betweem xxxx-12-01 to xxxx-12-31
     * @return
     */
    public List<Employee> alertAnnualReview(){
        Personnel personnel = Personnel.getInstance();
        List<Employee> list = personnel.getAllEmployee();
        List<Employee> res = new ArrayList<>();
        for(Employee e: list){
            if(withinOneMonth(this.date, e.getHireDate())){
                res.add(e);
            }
        }
        return res;
    }

    /**
     * Compare s1 and s2, if s1 <= s2 <= s1 + 1 month regardless of year, return true; else return false;
     * @param s1 date, format should strictly be "xxxx-xx-xx"
     * @param s2 date, format should strictly be "xxxx-xx-xx"
     * @return
     */
    private boolean withinOneMonth(String s1, String s2){
        String[] s1_arr = s1.split("-");
        int y1 = Integer.parseInt(s1_arr[0]);
        int m1 = Integer.parseInt(s1_arr[1]);
        int d1 = Integer.parseInt(s1_arr[2]);

        String[] s2_arr = s2.split("-");
        int y2 = Integer.parseInt(s2_arr[0]);
        int m2 = Integer.parseInt(s2_arr[1]);
        int d2 = Integer.parseInt(s2_arr[2]);

        if(y1>=y2){
            if((m1==m2 && d1<d2) || ((m1+1)%12==m2 && d1>=d2)){
                return true;
            }
        }
        return false;
    }
}
