# ![alt text](https://secure.gravatar.com/blavatar/4560c02ab420ca3cefc52ab44e8aefc1?s=32) Art with Lines




## DrawBezierCurve Function

If you want to create a generic Bezier Curve, just call
```java
public void DrawBezierCurve(Graphics g, int Size, int Resolution, double AngleDefinition) {
    int Final = ((int) Size / Resolution) * Resolution;
    int Start = 0;

    int UpBound   = (int) ((1 - Math.sin(AngleDefinition)) * Final);
    int LeftBound = (int) ((Math.cos(AngleDefinition)) * Final);

    for (int step = Start; step <= Final; step += Resolution) {
        int MoveX = LeftBound - (int)(step * Math.cos(AngleDefinition));
        int MoveY = UpBound   + (int)(step * Math.sin(AngleDefinition));
        g.drawLine(step, Final, MoveX, MoveY);
    }

    g.drawLine(0, Final, Final, Final);
    g.drawLine(0, Final, LeftBound, UpBound);
}
``` 

Remember:
	- **Size** Is the size to the square to contain your curve
	- **Resolution** Is the size of the step, smaller equals sharper
	- **AngleDefinition** Is the angle (in radians) of the curve

Let's see an example:
<center>	
	<img src="Graphics/BezierCurveExample01.png" width="80%" height="50%">
</center>

<center>	
	<img src="Graphics/BezierCurveExample02.png" width="80%" height="50%">
</center>

<center>	
	<img src="Graphics/BezierCurveExample03.png" width="80%" height="50%">
</center>


## Art with Lines (Bad Examples)
<center>	
	<img src="Graphics/Art1.png" width="80%" height="50%">
	<img src="Graphics/Art2.png" width="80%" height="50%">
	<img src="Graphics/Art3.png" width="80%" height="50%">
    <img src="Graphics/Art4.png" width="80%" height="50%">
    <img src="Graphics/Art5.png" width="80%" height="50%">
	<img src="Graphics/Artx.png" width="80%" height="50%">
</center>

