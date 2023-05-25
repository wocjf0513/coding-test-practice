import java.util.ArrayList;
import java.util.Iterator;

//DeliveryStore interface, Food and PizzaStore class are written as Inner Class. Read the code below and fill in the blank.
class Solution {
    interface DeliveryStore{
        public void setOrderList(String[] orderList);
        public int getTotalPrice();
    }
    
    class Food{
        public String name;
        public int price;
        public Food(String name, int price){
            this.name = name;
            this.price = price;
        }
    }
    
    class PizzaStore implements DeliveryStore {
        private ArrayList<Food> menuList;
        private ArrayList<String> orderList;
        
        public PizzaStore(){
            //init menuList
            menuList = new ArrayList<Food>();
            String[] menuNames = {"Cheese", "Potato", "Shrimp", "Pineapple", "Meatball"};
            int[] menuPrices = {11100, 12600, 13300, 21000, 19500};
            for(int i = 0; i < 5; i++)
                menuList.add(new Food(menuNames[i], menuPrices[i]));
            
            //init orderList
            orderList = new ArrayList<String>();
        }
        
        public void setOrderList(String[] orderList){
            for(int i = 0; i < orderList.length; i++)
                this.orderList.add(orderList[i]);
        }
        
        public int getTotalPrice(){
            int totalPrice = 0;
            Iterator<String> iter = orderList.iterator();
            while (iter.hasNext()) {
                String order = iter.next();
                for(int i = 0; i < menuList.size(); i++)
                    if(order.equals(menuList.get(i).name))
                        totalPrice += menuList.get(i).price;
            }
            return totalPrice;
        }
    }
    
    public int solution(String[] orderList) {
        DeliveryStore deliveryStore = new PizzaStore();
        
        deliveryStore.setOrderList(orderList);
        int totalPrice = deliveryStore.getTotalPrice();
        
        return totalPrice;
    }
    
    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] orderList = {"Cheese", "Pineapple", "Meatball"};
        int ret = sol.solution(orderList);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}