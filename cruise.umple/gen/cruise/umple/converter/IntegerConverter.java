package cruise.umple.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

public class IntegerConverter extends DefaultTerminalConverters {
	@ValueConverter(rule = "IntegerValue")
	public IValueConverter<Integer> ElementBound() {
		return new IValueConverter<Integer>() {
			public String toString(Integer value) {
				if (value == null)
					return "-1";
				if (value < 0)
					throw new ValueConverterException("INT-value may not be negative. (value:" + value + ").", null, null);
				return value.toString();
			}

			public Integer toValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to int.", node, null);
				try {
					return Integer.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to int.", node, e);
				}
			}
		};


	}
}
