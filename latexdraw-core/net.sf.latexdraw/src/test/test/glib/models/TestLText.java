package test.glib.models;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.sf.latexdraw.glib.models.ShapeFactory;
import net.sf.latexdraw.glib.models.interfaces.ICircle;
import net.sf.latexdraw.glib.models.interfaces.IPositionShape;
import net.sf.latexdraw.glib.models.interfaces.IRectangle;
import net.sf.latexdraw.glib.models.interfaces.IShape;
import net.sf.latexdraw.glib.models.interfaces.IText;
import net.sf.latexdraw.glib.views.Java2D.impl.FlyweightThumbnail;

import org.junit.Before;
import org.junit.Test;

import test.glib.models.interfaces.TestIText;

public class TestLText<T extends IText> extends TestIText<T> {
	@Before
	public void setUp() {
		FlyweightThumbnail.images().clear();
		FlyweightThumbnail.setThread(false);
		shape  = (T) ShapeFactory.createText(false);
		shape2 = (T) ShapeFactory.createText(false);
	}


	@Override
	@Test
	public void testIsTypeOf() {
		assertFalse(shape.isTypeOf(null));
		assertFalse(shape.isTypeOf(IRectangle.class));
		assertFalse(shape.isTypeOf(ICircle.class));
		assertTrue(shape.isTypeOf(IShape.class));
		assertTrue(shape.isTypeOf(IPositionShape.class));
		assertTrue(shape.isTypeOf(IText.class));
		assertTrue(shape.isTypeOf(shape.getClass()));
	}


	@Test
	public void testConstructors() {
		IText txt = ShapeFactory.createText(false);

		assertNotNull(txt.getText());
		assertTrue(txt.getText().length()>0);
		txt = ShapeFactory.createText(true);

		assertNotNull(txt.getText());
		assertTrue(txt.getText().length()>0);
		txt = ShapeFactory.createText(true, ShapeFactory.createPoint(), "coucou");

		assertNotNull(txt.getText());
		assertTrue(txt.getText().length()>0);
		txt = ShapeFactory.createText(true, ShapeFactory.createPoint(), "");

		assertNotNull(txt.getText());
		assertTrue(txt.getText().length()>0);
		txt = ShapeFactory.createText(true, ShapeFactory.createPoint(), null);

		assertNotNull(txt.getText());
		assertTrue(txt.getText().length()>0);

		txt = ShapeFactory.createText(false, null, "aa");
		assertEquals(ShapeFactory.createPoint(), txt.getPosition());
		txt = ShapeFactory.createText(false, ShapeFactory.createPoint(0, Double.NEGATIVE_INFINITY), "aa");
		assertEquals(ShapeFactory.createPoint(), txt.getPosition());
	}
}
