package ex1;

public class Main {
    public static void main(String[] args) {

        NutritionPlanBuilder builder = new WeightLossNutritionPlanBuilder();
        NutritionPlanDirector director = new NutritionPlanDirector(builder);
        NutritionPlan nutritionPlan = director.createNutritionPlan();
        System.out.println(nutritionPlan.getFitnessGoal());  // Output: weight loss
    }
}
