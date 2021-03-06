package module2;

public class FallingParticle {

	// Initialise variables
	// Private to avoid direct variable modification other than with appropriate methods
	private double m = 0;	// Particle mass (kg)
	private double d = 0;	// Drag coefficient (kg/m)
	private double z = 0;	// Particle height (m)
	private double t = 0;	// Simulation time (s)
	private double v = 0;	// Particle velocity (m/s) - positive is upwards
	private double height = 0;	// Initial simulation height (m)

	// Gravity variable
	public static final double g = 9.80665;

	// Class constructors
	public FallingParticle() {}
	
	public FallingParticle(double mass, double drag) {
		this.m = mass;
		this.d = drag;
		this.v = 0;
		this.t = 0;
	}

	// Set initial particle height 
	void setZ(double height) {
		this.height = height;
	}

	// Return particle position
	double getZ() {
		return this.z;
	}

	// Set particle velocity
	void setV(double velocity) {
		this.v = velocity;
	}

	// Return particle velocity
	double getV() {
		return this.v;
	}

	// Return current time
	double getT() {
		return this.t;
	}

	// Calculate single time step
	private void doTimeStep(double deltaT) {

		// Initialise necessary variables
		double deltaV = 0;
		double deltaZ = 0;
		double accel = 0;
		double drag = this.d;

		// Change sign of drag deceleration if particle moving upward
		if ( getV() > 0 ) {
			drag = -this.d;
		}

		// Calculate particle acceleration
		accel = ((this.v*this.v*drag)/this.m) - FallingParticle.g;

		// Update particle velocity from acceleration
		deltaV = accel*deltaT;
		this.v += deltaV;

		// Update particle position from velocity
		deltaZ = this.v*deltaT;
		this.z += deltaZ;

		// Update particle time
		this.t += deltaT;
		
	}

	// Drop method to calculate descent of particle
	void drop(double deltaT) {

		// Set initial parameters at start of drop
		this.z = this.height;
		this.t = 0;
		setV(0);

		// Loop over timesteps till particle reaches z = 0;
		while ( this.z > 0){
			doTimeStep(deltaT);	 
		}

		// Display final particle data
		System.out.println("Time step: "+deltaT+" s; Final position: "+getZ()+" m");
		System.out.println("Final time = "+getT()+" s; Final velocity = "+getV()+" m/s");
		System.out.println();

	}
}