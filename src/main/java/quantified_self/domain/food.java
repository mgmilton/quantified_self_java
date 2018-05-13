package quantified_self.domain;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

public class Food implements Identifiable {

      private Long id;
      private String name;
      private Long calories;

      @ManyToMany(mappedBy = "meals")
      private List<Meal> meals;
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
