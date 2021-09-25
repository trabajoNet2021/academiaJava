package logic;

import java.util.LinkedList;

import data.DataPlan;
import entities.Plan;

public class PlanLogic {
	
	DataPlan planData;
	
	public PlanLogic() {
		planData = new DataPlan();
	}
	
	//Done
	public LinkedList<Plan> getAll() {
		LinkedList<Plan> planes = planData.getAll();
		return planes;
	}
	
	//Done
	public Plan getOne(Plan plan) {
		Plan pl = planData.getOne(plan);
		return pl;
	}
	
	//Done
	public void insert(Plan plan) {
		planData.insert(plan);
	}

	//Done
	public void delete(Plan plan) {
		planData.delete(plan);
	}
	
	//Done
	public void update(Plan plan) {
		planData.update(plan);
	}
	
	
}
