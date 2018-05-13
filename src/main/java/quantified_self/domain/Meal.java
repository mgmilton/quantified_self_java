package quantified_self.domain;

public class Meal implements Identifiable {

      private Long id;
      private String name;

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
