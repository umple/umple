=begin
require 'test/unit'

require './src-gen-umple/y_1_1'
require './src-gen-umple/x_1_1'
require './src-gen-umple/yr_1_1'
require './src-gen-umple/z_1_1'
require './src-gen-umple/ym_1'
require './src-gen-umple/xm_1'
require './src-gen-umple/yr_m_1'
require './src-gen-umple/z_m_1'
require './src-gen-umple/ym_m'
require './src-gen-umple/xm_m'
require './src-gen-umple/yr_m_m'
require './src-gen-umple/z_m_m'
require './src-gen-umple/y_1_star'
require './src-gen-umple/x_1_star'
require './src-gen-umple/yr_1_star'
require './src-gen-umple/z_1_star'
require './src-gen-umple/ym_star'
require './src-gen-umple/xm_star'
require './src-gen-umple/yr_m_star'
require './src-gen-umple/z_m_star'
require './src-gen-umple/ystar_star'
require './src-gen-umple/xstar_star'
require './src-gen-umple/yr_star_star'
require './src-gen-umple/z_star_star'
require './src-gen-umple/ym_n__m'
require './src-gen-umple/xm_n__m'
require './src-gen-umple/yr_m_n__m'
require './src-gen-umple/z_m_n__m'
require './src-gen-umple/ym_n__1'
require './src-gen-umple/xm_n__1'
require './src-gen-umple/yr_m_n__1'
require './src-gen-umple/z_m_n__1'
require './src-gen-umple/ym_n__star'
require './src-gen-umple/xm_n__star'
require './src-gen-umple/yr_m_n__star'
require './src-gen-umple/z_m_n__star'
require './src-gen-umple/ym_n__m_n'
require './src-gen-umple/xm_n__m_n'
require './src-gen-umple/yr_m_n__m_n'
require './src-gen-umple/z_m_n__m_n'
require './src-gen-umple/y_0_n__1'
require './src-gen-umple/x_0_n__1'
require './src-gen-umple/yr_0_n__1'
require './src-gen-umple/z_0_n__1'
require './src-gen-umple/y_0_n__m'
require './src-gen-umple/x_0_n__m'
require './src-gen-umple/yr_0_n__m'
require './src-gen-umple/z_0_n__m'
require './src-gen-umple/y_0_n__star'
require './src-gen-umple/x_0_n__star'
require './src-gen-umple/yr_0_n__star'
require './src-gen-umple/z_0_n__star'
require './src-gen-umple/y_0_n__0_n'
require './src-gen-umple/x_0_n__0_n'
require './src-gen-umple/yr_0_n__0_n'
require './src-gen-umple/z_0_n__0_n'
require './src-gen-umple/y_0_1__m'
require './src-gen-umple/x_0_1__m'
require './src-gen-umple/yr_0_1__m'
require './src-gen-umple/z_0_1__m'
require './src-gen-umple/y_0_1__1'
require './src-gen-umple/x_0_1__1'
require './src-gen-umple/yr_0_1__1'
require './src-gen-umple/z_0_1__1'
require './src-gen-umple/y_0_1__star'
require './src-gen-umple/x_0_1__star'
require './src-gen-umple/yr_0_1__star'
require './src-gen-umple/z_0_1__star'
require './src-gen-umple/y_0_1__m_n'
require './src-gen-umple/x_0_1__m_n'
require './src-gen-umple/yr_0_1__m_n'
require './src-gen-umple/z_0_1__m_n'
require './src-gen-umple/y_0_1__0_n'
require './src-gen-umple/x_0_1__0_n'
require './src-gen-umple/yr_0_1__0_n'
require './src-gen-umple/z_0_1__0_n'
require './src-gen-umple/y_0_1__0_1'
require './src-gen-umple/x_0_1__0_1'
require './src-gen-umple/yr_0_1__0_1'
require './src-gen-umple/z_0_1__0_1'


module CruiseAssociationsCompositions
class CompositionMultiplicity_DeleteCodeTests  < Test::Unit::TestCase

  # 										LEFT TESTS

  
  def test_OneToOne_Left
 
    y = Y1_1.new(nil)
    x = X1_1.new(1, y)
    x.delete   

    assert_equal(nil, y.get_xVar)
    assert_equal(nil, x.get_y1_1)
  end

  
  def test_MToOne_Left
  
    x = XM_1.new(1)
    y = YM_1.new(x)
    x.delete    

    assert_equal(nil, y.get_xVar)
    assert_equal(0, x.get_ym_1.length)
  end

  
  def test_MToM_Left
  
    y1 = YM_M.new
    y2 = YM_M.new
    y2.set_v(2)
    y3 = YM_M.new
    y3.set_v(3)
     
    x = XM_M.new(1) 
    x.set_ym_m([y1, y2, y3])    

    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, y3.get_xVar.length)
    assert_equal(0, x.get_ym_m.length)
  end

  
  def test_OneToStar_Left
  
    y = Y1_star.new
    
    x = X1_star.new(1, y) 

    x.delete    

    assert_equal(0, y.get_xVar.length)
    assert_equal(nil, x.get_y1_star)
  end

 
  def test_MToStar_Left
  
    y1 = YM_star.new
    y2 = YM_star.new
    y2.set_v(2)
    y3 = YM_star.new
    y3.set_v(3)
     
    x = XM_star.new(1, [y1, y2, y3]) 

    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, y3.get_xVar.length)
    assert_equal(0, x.get_ym_star.length)
  end

   
  def test_StarToStar_Left
  
    y1 = Ystar_star.new 
    y2 = Ystar_star.new
    y2.set_v(2)
    y3 = Ystar_star.new
    y3.set_v(3)	     

    x1 = Xstar_star.new(1)
    x1.add_ystar_star(y1)
    x1.add_ystar_star(y2)
    x1.add_ystar_star(y3)
    x2 = Xstar_star.new(2) 
    x2.add_ystar_star(y1)
    x2.add_ystar_star(y2)

    x1.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, y3.get_xVar.length)
    assert_equal(0, x1.get_ystar_star.length)
    assert_equal(0, x2.get_ystar_star.length)
  end
  
  def test_MNToOne_Left
  
    x = Xm_n__1.new(1)
    y = Ym_n__1.new(x)
    x.delete    

    assert_equal(nil, y.get_xVar)
    assert_equal(0, x.get_ym_n__1.length)
  end

  
  def test_MNToM_Left
  
    y1 = Ym_n__m.new
    y2 = Ym_n__m.new
    y3 = Ym_n__m.new
     
    x = Xm_n__m.new(1) 
    x.set_ym_n__m([y1, y2, y3])    

    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, y3.get_xVar.length)
    assert_equal(0, x.get_ym_n__m.length)
  end

  
  def test_MNToStar_Left
  
    y1 = Ym_n__star.new
    y2 = Ym_n__star.new
    y3 = Ym_n__star.new
     
    x = Xm_n__star.new(1, [y1, y2]) 
    x.add_ym_n__star(y3)
   
    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, y3.get_xVar.length)
    assert_equal(0, x.get_ym_n__star.length)
  end

  
  def test_MNToMN_Left
  
    y1 = Ym_n__m_n.new
    y2 = Ym_n__m_n.new
     
    x = Xm_n__m_n.new(1) 
    x.set_ym_n__m_n([y1, y2])    

    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, x.get_ym_n__m_n.length)
  end

  
  def test__0NToOne_Left
  
    x = X0_n__1.new(1)
    y = Y0_n__1.new(x)
    x.delete    

    assert_equal(nil, y.get_xVar)
    assert_equal(0, x.get_y0_n__1.length)
  end

  
  def test__0NToM_Left
  
    y1 = Y0_n__m.new
    y2 = Y0_n__m.new
    y3 = Y0_n__m.new
     
    x = X0_n__m.new(1) 
    x.add_y0_n__m(y1)
    x.add_y0_n__m(y2)
    x.add_y0_n__m(y3)
    
    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, y3.get_xVar.length)
    assert_equal(0, x.get_y0_n__m.length)
  end

  
  def test__0NToStar_Left
  
    y1 = Y0_n__star.new
    y2 = Y0_n__star.new
     
    x = X0_n__star.new(1) 
    x.add_y0_n__star(y1)
    x.add_y0_n__star(y2)
   
    x.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, x.get_y0_n__star.length)
  end

  
  def test__0NTo0N_Left
  
    y1 = Y0_n__0_n.new
    y2 = Y0_n__0_n.new
     
    x1 = X0_n__0_n.new(1) 
    x1.add_y0_n__0_n(y1)
    x1.add_y0_n__0_n(y2)   
    x2 = X0_n__0_n.new(2) 
    x2.add_y0_n__0_n(y1)
    x2.add_y0_n__0_n(y2) 

    x1.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(0, y2.get_xVar.length)
    assert_equal(0, x1.get_y0_n__0_n.length)
    assert_equal(0, x2.get_y0_n__0_n.length)
  end

  
  def test__0OneToOne_Left
  
    x = X0_1__1.new(1)
    y = Y0_1__1.new(x)
    y.get_xVar.delete    

    assert_equal(nil, y.get_xVar)
    assert_equal(nil, x.get_y0_1__1)
  end

  
  def test__0OneToM_Left
  
    x1 = X0_1__m.new(1)
    x2 = X0_1__m.new(2)
    x3 = X0_1__m.new(3)
     
    y = Y0_1__m.new([x1, x2, x3]) 
    
    x1.delete    

    assert_equal(nil, x1.get_y0_1__m)
    assert_equal(nil, x2.get_y0_1__m)
    assert_equal(nil, x3.get_y0_1__m)
    assert_equal(0, y.get_xVar.length)
  end

  
  def test__0OneToStar_Left
  
    y = Y0_1__star.new
    
    x = X0_1__star.new(1) 
    x.set_y0_1__star(y)

    x.delete    

    assert_equal(0, y.get_xVar.length)
    assert_equal(nil, x.get_y0_1__star)
  end


  def test__0OneToMN_Left
  
    x1 = X0_1__m_n.new(1)
    x2 = X0_1__m_n.new(2)
    x3 = X0_1__m_n.new(3) 
    
    y = Y0_1__m_n.new([x1, x2, x3])

    x1.delete    

    assert_equal(0, y.get_xVar.length)
    assert_equal(nil, x1.get_y0_1__m_n)
    assert_equal(nil, x2.get_y0_1__m_n)
    assert_equal(nil, x3.get_y0_1__m_n)
  end

 
  def test__01To0N_Left
  
    y1 = Y0_1__0_n.new
     
    x1 = X0_1__0_n.new(1) 
    x1.set_y0_1__0_n(y1)
    x2 = X0_1__0_n.new(2) 
    x2.set_y0_1__0_n(y1)
    
    x1.delete    

    assert_equal(0, y1.get_xVar.length)
    assert_equal(nil, x1.get_y0_1__0_n)
    assert_equal(nil, x2.get_y0_1__0_n)
  end


  
  def test__0OneTo0One_Left
  
    x = X0_1__0_1.new(1)
    y = Y0_1__0_1.new
    y.set_xVar(x)
    
    x.delete    

    assert_equal(nil, y.get_xVar)
    assert_equal(nil, x.get_y0_1__0_1)
  end







   # 										RIGHT TESTS

  
  def test_OneToOne_Right
  
    y = YR_1_1.new(nil)
    z = Z_1_1.new(1, y)
    y.delete   

    assert_equal(nil, y.get_zVar)
    assert_equal(nil, z.get_y_1_1)
  end

  
  def test_MToOne_Right
  
    z = Z_M_1.new(1)
    y = YR_M_1.new(z)
    z.delete    

    assert_equal(nil, y.get_zVar)
    assert_equal(0, z.get_y_m_1.length)
  end

 
  def test_MToM_Right
  
    y1 = YR_M_M.new
    y2 = YR_M_M.new
    y3 = YR_M_M.new
     
    z = Z_M_M.new(1) 
    z.set_y_m_m([y1, y2, y3])    

    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, y3.get_zVar.length)
    assert_equal(0, z.get_y_m_m.length)
  end

  
  def test_OneToStar_Right
  
    y = YR_1_star.new
    
    z = Z_1_star.new(1, y) 

    z.delete    

    assert_equal(0, y.get_zVar.length)
    assert_equal(nil, z.get_y_1_star)
  end

  
  def test_MToStar_Right
  
    y1 = YR_M_star.new
    y2 = YR_M_star.new
    y3 = YR_M_star.new
     
    z = Z_M_star.new(1, [y1, y2, y3]) 

    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, y3.get_zVar.length)
    assert_equal(0, z.get_y_m_star.length)
  end

  
  def test_StarToStar_Right
  
    y1 = YR_star_star.new
    y2 = YR_star_star.new
    y3 = YR_star_star.new
     
    z1 = Z_star_star.new(1)
    z1.add_y_star_star(y1)
    z1.add_y_star_star(y2)
    z1.add_y_star_star(y3)
    z2 = Z_star_star.new(2) 
    z2.add_y_star_star(y1)
    z2.add_y_star_star(y2)

    y1.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, y3.get_zVar.length)
    assert_equal(0, z1.get_y_star_star.length)
    assert_equal(0, z2.get_y_star_star.length)
  end

  
  def test_MNToOne_Right
  
    z = Z_m_n__1.new(1)
    y = YR_m_n__1.new(z)
    z.delete    

    assert_equal(nil, y.get_zVar)
    assert_equal(0, z.get_y_m_n__1.length)
  end

  
  def test_MNToM_Right
  
    y1 = YR_m_n__m.new
    y2 = YR_m_n__m.new
    y3 = YR_m_n__m.new
     
    z = Z_m_n__m.new(1) 
    z.set_y_m_n__m([y1, y2, y3])    

    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, y3.get_zVar.length)
    assert_equal(0, z.get_y_m_n__m.length)
  end

  
  def test_MNToStar_Right
  
    y1 = YR_m_n__star.new
    y2 = YR_m_n__star.new
    y3 = YR_m_n__star.new
     
    z = Z_m_n__star.new(1, [y1, y2]) 
    z.add_y_m_n__star(y3)
   
    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, y3.get_zVar.length)
    assert_equal(0, z.get_y_m_n__star.length)
  end

  
  def test_MNToMN_Right
  
    y1 = YR_m_n__m_n.new
    y2 = YR_m_n__m_n.new
     
    z = Z_m_n__m_n.new(1) 
    z.set_y_m_n__m_n([y1, y2])    

    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, z.get_y_m_n__m_n.length)
  end

  
  def test__0NToOne_Right
  
    z = Z_0_n__1.new(1)
    y = YR_0_n__1.new(z)
    z.delete    

    assert_equal(nil, y.get_zVar)
    assert_equal(0, z.get_y_0_n__1.length)
  end

 
  def test__0NToM_Right
  
    y1 = YR_0_n__m.new
    y2 = YR_0_n__m.new
    y3 = YR_0_n__m.new
     
    z = Z_0_n__m.new(1) 
    z.add_y_0_n__m(y1)
    z.add_y_0_n__m(y2)
    z.add_y_0_n__m(y3)
    
    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, y3.get_zVar.length)
    assert_equal(0, z.get_y_0_n__m.length)
  end

  
  def test__0NToStar_Right
  
    y1 = YR_0_n__star.new
    y2 = YR_0_n__star.new
     
    z = Z_0_n__star.new(1) 
    z.add_y_0_n__star(y1)
    z.add_y_0_n__star(y2)
   
    z.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, z.get_y_0_n__star.length)
  end

   
  def test__0NTo0N_Right
  
    y1 = YR_0_n__0_n.new
    y2 = YR_0_n__0_n.new
     
    z1 = Z_0_n__0_n.new(1) 
    z1.add_y_0_n__0_n(y1)
    z1.add_y_0_n__0_n(y2)   
    z2 = Z_0_n__0_n.new(2) 
    z2.add_y_0_n__0_n(y1)
    z2.add_y_0_n__0_n(y2) 

    y1.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(0, y2.get_zVar.length)
    assert_equal(0, z1.get_y_0_n__0_n.length)
    assert_equal(0, z2.get_y_0_n__0_n.length)
  end

  
  def test__0OneToOne_Right
  
    z = Z_0_1__1.new(1)
    y = YR_0_1__1.new(z)
    y.get_zVar.delete    

    assert_equal(nil, y.get_zVar)
    assert_equal(nil, z.get_y_0_1__1)
  end
 
  def test__0OneToM_Right
  
    z1 = Z_0_1__m.new(1)
    z2 = Z_0_1__m.new(2)
    z3 = Z_0_1__m.new(3)
     
    y = YR_0_1__m.new([z1, z2, z3]) 
    
    z1.delete    

    assert_equal(nil, z1.get_y_0_1__m)
    assert_equal(nil, z2.get_y_0_1__m)
    assert_equal(nil, z3.get_y_0_1__m)
    assert_equal(0, y.get_zVar.length)
  end

  
  def test__0OneToStar_Right
  
    y = YR_0_1__star.new
    
    z = Z_0_1__star.new(1) 
    z.set_y_0_1__star(y)

    z.delete    

    assert_equal(0, y.get_zVar.length)
    assert_equal(nil, z.get_y_0_1__star)
  end

 
  def test__0OneToMN_Right
  
    z1 = Z_0_1__m_n.new(1)
    z2 = Z_0_1__m_n.new(2)
    z3 = Z_0_1__m_n.new(3) 
    
    y = YR_0_1__m_n.new([z1, z2, z3])

    y.delete    

    assert_equal(0, y.get_zVar.length)
    assert_equal(nil, z1.get_y_0_1__m_n)
    assert_equal(nil, z2.get_y_0_1__m_n)
    assert_equal(nil, z3.get_y_0_1__m_n)
  end
  
  
  def test__01To0N_Right
  
    y1 = YR_0_1__0_n.new
     
    z1 = Z_0_1__0_n.new(1) 
    z1.set_y_0_1__0_n(y1)
    z2 = Z_0_1__0_n.new(2) 
    z2.set_y_0_1__0_n(y1)
    
    y1.delete    

    assert_equal(0, y1.get_zVar.length)
    assert_equal(nil, z1.get_y_0_1__0_n)
    assert_equal(nil, z2.get_y_0_1__0_n)
  end

  
  def test__0OneTo0One_Right
  
    z = Z_0_1__0_1.new(1)
    y = YR_0_1__0_1.new
    y.set_zVar(z)
    
    z.delete    

    assert_equal(nil, y.get_zVar)
    assert_equal(nil, z.get_y_0_1__0_1)
  end

end
end
=end
