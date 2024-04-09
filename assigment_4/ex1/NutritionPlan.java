package ex1;

import java.util.List;


class NutritionPlan {
    private int caloricIntake;
    private int carbohydratesRatio;
    private int proteinsRatio;
    private int fatsRatio;
    private List<String> mealPlans;
    private String fitnessGoal;
    private List<String> dietaryRestrictions;

    // Constructor, getters, and setters
    // Constructor
    public NutritionPlan() {
    }

    // Getters and setters
    public int getCaloricIntake() {
        return caloricIntake;
    }

    public void setCaloricIntake(int caloricIntake) {
        this.caloricIntake = caloricIntake;
    }

    public int getCarbohydratesRatio() {
        return carbohydratesRatio;
    }

    public void setCarbohydratesRatio(int carbohydratesRatio) {
        this.carbohydratesRatio = carbohydratesRatio;
    }

    public int getProteinsRatio() {
        return proteinsRatio;
    }

    public void setProteinsRatio(int proteinsRatio) {
        this.proteinsRatio = proteinsRatio;
    }

    public int getFatsRatio() {
        return fatsRatio;
    }

    public void setFatsRatio(int fatsRatio) {
        this.fatsRatio = fatsRatio;
    }

    public List<String> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(List<String> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(List<String> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}


class NutritionPlanBuilder {
    private NutritionPlan nutritionPlan;

    public NutritionPlanBuilder() {
        this.nutritionPlan = new NutritionPlan();
    }

    public NutritionPlanBuilder setCaloricIntake(int caloricIntake) {
        nutritionPlan.setCaloricIntake(caloricIntake);
        return this;
    }

    public NutritionPlanBuilder setMacronutrientRatios(int carbohydratesRatio, int proteinsRatio, int fatsRatio) {
        nutritionPlan.setCarbohydratesRatio(carbohydratesRatio);
        nutritionPlan.setProteinsRatio(proteinsRatio);
        nutritionPlan.setFatsRatio(fatsRatio);
        return this;
    }

    public NutritionPlanBuilder setMealPlans(List<String> mealPlans) {
        nutritionPlan.setMealPlans(mealPlans);
        return this;
    }

    public NutritionPlanBuilder setFitnessGoal(String fitnessGoal) {
        nutritionPlan.setFitnessGoal(fitnessGoal);
        return this;
    }

    public NutritionPlanBuilder setDietaryRestrictions(List<String> dietaryRestrictions) {
        nutritionPlan.setDietaryRestrictions(dietaryRestrictions);
        return this;
    }

    public NutritionPlan build() {
        return nutritionPlan;
    }
}


class NutritionPlanDirector {
    private NutritionPlanBuilder builder;

    public NutritionPlanDirector(NutritionPlanBuilder builder) {
        this.builder = builder;
    }

    public NutritionPlan createNutritionPlan() {
        return builder.build();
    }
}


class WeightLossNutritionPlanBuilder extends NutritionPlanBuilder {
    public WeightLossNutritionPlanBuilder() {
        super();
        this.setFitnessGoal("weight loss");
    }
}

class WeightGainNutritionPlanBuilder extends NutritionPlanBuilder {
    public WeightGainNutritionPlanBuilder() {
        super();
        this.setFitnessGoal("weight gain");
    }
}

class MaintenanceNutritionPlanBuilder extends NutritionPlanBuilder {
    public MaintenanceNutritionPlanBuilder() {
        super();
        this.setFitnessGoal("maintenance");
    }
}


