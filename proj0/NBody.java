public class NBody{
	public static Planet[] readPlanets(String args){
		In in=new In(args);
		if(in.isEmpty()){
			System.out.println("please provide an effective filenam");
			return null;
		}
		int count=in.readInt();
		double radius=in.readDouble();
		Planet[]  B=new Planet[count];
		for(int i=0;i<count;i++){
			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String imgFileNmae=in.readString();
			B[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileNmae);
//			B[i]=new Body(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}

		return B;

	}
	
	public static double readRadius(String filename){
		In in =new In(filename);
		if(in.isEmpty()){
			System.out.println("Please provide an effective filename");
			return 0.0;
		}
		int count=in.readInt();
		double radius=in.readDouble();
		return radius;
	}
	public static void main(String[] args){
		double T,dt;
		T=Double.parseDouble(args[0]);
		dt=Double.parseDouble(args[1]);
		String filename=args[2];
		double radius=readRadius(filename);
		Planet[] B=readPlanets(filename);
		StdDraw.setScale(-2*radius,2*radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		StdDraw.enableDoubleBuffering();
		double t=0;
		for(;t<=T;t+=dt){
			double[] xForces=new double[B.length];
			double[] yForces=new double[B.length];
			double xforce,yforce;
			for(int i=0;i<B.length;i++){
				xforce=yforce=0;
				xforce=B[i].calcNetForceExertedByX(B);
				yforce=B[i].calcNetForceExertedByY(B);
				xForces[i]=xforce;
				yForces[i]=yforce;
			}
			for(int i=0;i<B.length;i++){
				B[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<B.length;i++){
				B[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		
	//print out the state of the universe
	System.out.println(B.length);
	System.out.println(radius);
	for(int i=0;i<B.length;i++){
		System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",B[i].xxPos,B[i].yyPos,B[i].xxVel,B[i].yyVel,B[i].mass,B[i].imgFileName);
	}
}
}
