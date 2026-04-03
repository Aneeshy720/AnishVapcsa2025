package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        solve(0, 2, 1, model.height()); 
        model.print(); 
    }

    public void solve(int source, int destination, int intermediate, int height){
        if(height==1){
            model.move(source, destination); 
        }
        else{
            solve(source, intermediate, destination, height - 1); 
            model.print(); 
            model.move(source, destination); 
            model.print(); 
            solve(intermediate, destination, source, height-1); 
            model.print(); 
        } 
    }
    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    //

}
