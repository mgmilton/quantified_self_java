package quantified_self.domain;

import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;

public class Meal implements Identifiable {

      private Long id;
      private String name;

      @ManyToMany
      @JoinTable(name = "meal_foods",
        joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "meal_id", referencedColumnName = "id"))

      private List<Food> foods;

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
}
