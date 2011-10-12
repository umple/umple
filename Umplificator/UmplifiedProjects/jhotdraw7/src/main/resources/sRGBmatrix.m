function [ M ] = sRGBmatrix()
%Computes the sRGBmatrix

%D65 whitepoint
xw = 0.3127;
yw = 0.3290;

Yw = 1;
Xw = xw*Yw/yw;
Zw = (1-xw-yw)*Yw/yw;

M = xyToRGBmatrix( 0.64, 0.33, 0.3, 0.6, 0.15, 0.06, Xw, Yw, Zw );

end

