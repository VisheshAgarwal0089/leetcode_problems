class Solution {
    public boolean checkOverlap(int radius, int xcenter, int ycenter, int x1, int y1, int x2, int y2) {
        // if(xcenter+radius>=x1 && ycenter+radius>=y1&& xcenter-radius<=x2 && ycenter-radius<=y2){
        //     return true;
        // }
        // return false;
        int xi,yi;
        if(x1>xcenter)xi=x1;
        else if(x2<xcenter)xi=x2;
        else xi=xcenter;
        if(y1>ycenter)yi=y1;
        else if(y2<ycenter)yi=y2;
        else yi=ycenter;
        if(Math.pow(xi-xcenter,2)+Math.pow(yi-ycenter,2)<=radius*radius){
        return true;}
        return false;
    }
}