package quantified_self;

public class Food implements Indentifiable {

      private Long id;
      private String name;
      private Long calories;

      @Override
      public Long getId(){
        return id;
      }

      @Override
      public void setId(Long id){
        this.id = id;
      }

      public String getName(){
        return name;
      }

      public void setName(String name){
        this.name = name;
      }

      public long getCalories() {
        return calories;
      }

      public void setCalories(long calories){
        this.calories = calories;
      }
}
