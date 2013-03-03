package test.glib.views.java2D;

import org.junit.Before;

import net.sf.latexdraw.glib.models.impl.LShapeFactory;
import net.sf.latexdraw.glib.models.interfaces.DrawingTK;
import net.sf.latexdraw.glib.models.interfaces.IGroup;
import net.sf.latexdraw.glib.models.interfaces.IShapeFactory;
import net.sf.latexdraw.glib.views.Java2D.impl.LViewsFactory;
import net.sf.latexdraw.glib.views.Java2D.interfaces.IViewShape;
import net.sf.latexdraw.glib.views.Java2D.interfaces.IViewsFactory;
import net.sf.latexdraw.glib.views.Java2D.interfaces.View2DTK;
import junit.framework.TestCase;

public class TestViewFactory extends TestCase {
	protected IViewsFactory viewFac;
	
	protected IShapeFactory shFac;
	
	static {
		DrawingTK.setFactory(new LShapeFactory());
		View2DTK.setFactory(new LViewsFactory());
	}
	
	
	@Before
	@Override
	public void setUp() {
		viewFac = View2DTK.getFactory();
		shFac	= DrawingTK.getFactory();
	}
	
	
	public void testCreateGroupView() {
		IGroup gp = shFac.createGroup(false);
		gp.addShape(shFac.createText(false));
		IViewShape view = viewFac.createView(gp);
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("group"));
	}
	
	
	public void testCreateTextView() {
		IViewShape view = viewFac.createView(shFac.createText(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("text"));
	}
	
	
	public void testCreateArcCircleView() {
		IViewShape view = viewFac.createView(shFac.createCircleArc(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("circlearc"));
	}
	
	public void testCreateRectangleView() {
		IViewShape view = viewFac.createView(shFac.createRectangle(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("rectangle"));
	}
	
	public void testCreateSquareView() {
		IViewShape view = viewFac.createView(shFac.createSquare(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("square"));
	}
	
	public void testCreateEllipseView() {
		IViewShape view = viewFac.createView(shFac.createEllipse(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("ellipse"));
	}
	
	public void testCreateCircleView() {
		IViewShape view = viewFac.createView(shFac.createCircle(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("circle"));
	}
	
	public void testCreateGridView() {
		IViewShape view = viewFac.createView(shFac.createGrid(false, shFac.createPoint()));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("grid"));
	}
	
	public void testCreateAxesView() {
		IViewShape view = viewFac.createView(shFac.createAxes(false, shFac.createPoint()));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("axes"));
	}
	
	public void testCreatePolygonView() {
		IViewShape view = viewFac.createView(shFac.createPolygon(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("polygon"));
	}
	
	public void testCreatePolylineView() {
		IViewShape view = viewFac.createView(shFac.createPolyline(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("polyline"));
	}
	
	public void testCreateTriangleView() {
		IViewShape view = viewFac.createView(shFac.createTriangle(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("triangle"));
	}
	
	public void testCreateRhombusView() {
		IViewShape view = viewFac.createView(shFac.createRhombus(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("rhombus"));
	}
	
	public void testCreateFreehandView() {
		IViewShape view = viewFac.createView(shFac.createFreeHand(shFac.createPoint(), false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("freehand"));
	}
	
	public void testCreatePictureView() {
		IViewShape view = viewFac.createView(shFac.createPicture(false, shFac.createPoint()));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("picture"));
	}
	
	public void testCreateDotView() {
		IViewShape view = viewFac.createView(shFac.createDot(shFac.createPoint(), false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("dot"));
	}
	
	public void testCreateBezierCurveView() {
		IViewShape view = viewFac.createView(shFac.createBezierCurve(false));
		assertNotNull(view);
		assertTrue(view.getClass().getName().toLowerCase().contains("beziercurve"));
	}
}