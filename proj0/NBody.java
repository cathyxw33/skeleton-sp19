public class NBody {
    public static double readRadius(String s){
        In in = new In(s);
        int num = in.readInt();
        double v = in.readDouble();
        return v;

    }
    public static Body[] readBodies(String s){
        In in = new In(s);
        int num = in.readInt();
        Body[] whole = new Body[num];
        int count = 0;
        double radius = in.readDouble();
        while (!in.isEmpty()){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            whole[count] = new Body(xP, yP, xV, yV, m, img);
            count = count + 1;
        }
        return whole;

    }



}
