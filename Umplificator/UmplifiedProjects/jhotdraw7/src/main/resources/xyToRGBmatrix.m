function [ M ] = xyToRGBmatrix( xr, yr, xg, yg, xb, yb, Xw, Yw, Zw )
%Computes the matrix M for conversion from xy CIE Chart coordinates
%RGB color values given the xy coordinates of the red, green and blue
%primary colors and the XYZ coordinates of the reference white.
%
% xr - x coordinate of the red primary
% yr - y coordinate of the red primary
% xg - x coordinate of the green primary
% yg - y coordinate of the green primary
% xb - x coordinate of the blue primary
% yb - y coordinate of the blue primary
% Xw - X coordinate of the reference white 
% Yw - Y coordinate of the reference white 
% Zw - Z coordinate of the reference white 

Xr = xr/yr;
Yr = 1;
Zr = (1-xr-yr)/yr;

Xg = xg/yg;
Yg = 1;
Zg = (1-xg-yg)/yg;

Xb = xb/yb;
Yb = 1;
Zb = (1-xb-yb)/yb;

A = [Xr Xg Xb; Yr Yg Yb; Zr Zg Zb];

S = inv(A)*[Xw;Yw;Zw];
Sr = S(1);
Sg = S(2);
Sb = S(3);

M = [Sr*Xr Sg*Xg Sb*Xb; Sr*Yr Sg*Yg Sb*Yb; Sr*Zr Sg*Zg Sb*Zb];

M = inv(M);

end

