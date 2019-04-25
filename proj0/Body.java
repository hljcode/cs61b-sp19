public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public   double G=6.67e-11;
	public Body(double xP,double yP,double xV,double yV,double m,String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName="images/"+img;
	}
	public Body(Body b){
		xxPos=b.xxPos;
		yyPos=b.yyPos;
		xxVel=b.xxVel;
		yyVel=b.yyVel;
		imgFileName=b.imgFileName;
	}
	public Body(){
		xxPos=yyPos=xxVel=yyVel=0;
	}
	public double  abs(double c){
		if(c<0)
			return -c;
		return c;
	}
	public double calcDistance(Body b){
		double dx,dy;
		dx=abs(this.xxPos-b.xxPos);
		dy=abs(this.yyPos-b.yyPos);
		return Math.sqrt(dx*dx+dy*dy);
	}
	public double calcForceExertedBy(Body b){
		double r=this.calcDistance(b);
		return (G*(this.mass)*(b.mass))/(r*r);
	}
	public double calcForceExertedByX(Body b){
		double dx=b.xxPos-this.xxPos;
		return this.calcForceExertedBy(b)*(dx/this.calcDistance(b));
	}
	public double calcForceExertedByY(Body b){
		double dy=b.yyPos-this.yyPos;
		return this.calcForceExertedBy(b)*(dy/this.calcDistance(b));
	}
	public double calcNetForceExertedByX(Body[] b){
		double netforce=0.0;
		for(int i=0;i<b.length;i++){
			if(b[i].equals(this))
				continue;
			netforce+=this.calcForceExertedByX(b[i]);
		}
		return netforce;
	}
	public double calcNetForceExertedByY(Body[] b){
		double netforce=0.0;
		for(int i=0;i<b.length;i++){
			if(b[i].equals(this))
				continue;
			netforce+=this.calcForceExertedByY(b[i]);
		}
		return netforce;
	}
	public static void windowPosSum(int a[],int n){
		for(int i=0;i<a.length;i++){
			if(a[i]<=0)
				continue;
			int index=1;
			while((i+index<a.length)&&(index<=n)){
				a[i]+=a[i+index];
				index++;
			}
		}
		return;
	}
	public void update(double dt,double N1,double N2){
		double a_x=N1/this.mass;
		double a_y=N2/this.mass;
		xxVel+=a_x*dt;
		yyVel+=a_y*dt;
		xxPos+=xxVel*dt;
		yyPos+=yyVel*dt;
		return;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,imgFileName);
		return;
	}
}

