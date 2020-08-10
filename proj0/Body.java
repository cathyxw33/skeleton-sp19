
public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;

    }

    public double calcDistance(Body a) {
        double x = a.xxPos - this.xxPos;
        double y = a.yyPos - this.yyPos;
        double r_squre = x * x + y * y;
        double r = Math.sqrt(r_squre);
        return r;
    }

    public double calcForceExertedBy(Body a) {
        double F = G * this.mass * a.mass / Math.pow((this.calcDistance(a)),2);
        return F;

    }

    public double calcForceExertedByX(Body a) {
        double dx = a.xxPos - this.xxPos;
        double F_x = (this.calcForceExertedBy(a) * dx) / this.calcDistance(a);
        return F_x;
    }

    public double calcForceExertedByY(Body a) {
        double dy = a.yyPos - this.yyPos;
        double F_y = (this.calcForceExertedBy(a) * dy) / this.calcDistance(a);
        return F_y;
    }

    public double calcNetForceExertedByX(Body[] s){
        double F_netX = 0;
        for (int i = 0; i < s.length; i = i+1){
                if (!this.equals(s[i])) {
                    F_netX = F_netX + this.calcForceExertedByX(s[i]);
                }
            }
        return F_netX;
        }

    public double calcNetForceExertedByY(Body[] s){
        double F_netY = 0;
        for (int i = 0; i < s.length; i = i+1){
            if (!this.equals(s[i])) {
                F_netY = F_netY + this.calcForceExertedByY(s[i]);
            }
        }
        return F_netY;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;

    }


        }