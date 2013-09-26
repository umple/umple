package cruise.umple.ui.eclipse.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;

public class UmpleDamagerRepairer extends DefaultDamagerRepairer{

	private List<ITypedRegion> regions = new ArrayList<ITypedRegion>();

	public UmpleDamagerRepairer(ITokenScanner scanner) {
		super(scanner);
	}

	@Override
	public void createPresentation(TextPresentation presentation, ITypedRegion region) {

		if (fScanner == null) {
			// will be removed if deprecated constructor will be removed
			addRange(presentation, region.getOffset(), region.getLength(), fDefaultTextAttribute);
			return;
		}

		int lastStart= region.getOffset();
		int length= 0;
		boolean firstToken= true;
		IToken lastToken= Token.UNDEFINED;
		TextAttribute lastAttribute= getTokenTextAttribute(lastToken);

		//fScanner.setRange(fDocument, lastStart, region.getLength());

		checkAttribute(presentation, fDocument, lastStart, region.getLength());
		
		while (true) {
			IToken token= fScanner.nextToken();
			if (token.isEOF())
				break;

			TextAttribute attribute= getTokenTextAttribute(token);
			if (lastAttribute != null && lastAttribute.equals(attribute)) {
				length += fScanner.getTokenLength();
				firstToken= false;
			} else {
				if (!firstToken)
					addRange(presentation, lastStart, length, lastAttribute);
				firstToken= false;
				lastToken= token;
				lastAttribute= attribute;
				lastStart= fScanner.getTokenOffset();
				length= fScanner.getTokenLength();
			}
		}

		addRange(presentation, lastStart, length, lastAttribute);

		if(regions.size()>0){
			runRules(presentation, regions.remove(0));
		}
	}

	public void runRules(TextPresentation presentation, ITypedRegion region) {

		if (fScanner == null) {
			// will be removed if deprecated constructor will be removed
			addRange(presentation, region.getOffset(), region.getLength(), fDefaultTextAttribute);
			return;
		}

		int lastStart= region.getOffset();
		int length= 0;
		boolean firstToken= true;
		IToken lastToken= Token.UNDEFINED;
		TextAttribute lastAttribute= getTokenTextAttribute(lastToken);

		fScanner.setRange(fDocument, lastStart, region.getLength());

		while (true) {
			IToken token= fScanner.nextToken();
			if (token.isEOF())
				break;

			TextAttribute attribute= getTokenTextAttribute(token);
			if (lastAttribute != null && lastAttribute.equals(attribute)) {
				length += fScanner.getTokenLength();
				firstToken= false;
			} else {
				if (!firstToken)
					addRange(presentation, lastStart, length, lastAttribute);
				firstToken= false;
				lastToken= token;
				lastAttribute= attribute;
				lastStart= fScanner.getTokenOffset();
				length= fScanner.getTokenLength();
			}
		}

		addRange(presentation, lastStart, length, lastAttribute);

		if(regions.size()>0){
			runRules(presentation, regions.remove(0));
		}
	}

	private void checkAttribute(TextPresentation presentation,IDocument document, int offset, int length) {
		UmpleScanner scanner = (UmpleScanner)fScanner;
		scanner.reset();
		Scope child = null;
		//for(Scope scope:scanner.rootScope.children){
		//	scope.adjust(offset,scanner.getDifference(document.getLength()));
		//}
		for(Scope scope:scanner.rootScope.children){
			if(scope.getBegin()<=offset&&scope.getEnd()>=offset+length){
				child = scope.getChildWithin(offset,offset+length);
				/*This comment is for the hope of speeding up attribute re-colouring
				 * try {
					String input = document.get(offset, length);
					AttributeDefinition ad = null;
					String[] split = input.split("[\\s;=]");
					for(int i=0;i<split.length;i++){
						ad=child.getAttribute(split[i]);
						if(ad!=null){
							//formed == add new or check all
							if(i>0&&split[i-1].matches("[a-zA-Z][a-zA-Z0-9<.*>_-]*\\[?\\]?")){
								// new	
								String scopeString = document.get(child.getBegin(),child.getEnd()-child.getBegin());
								int begin = scopeString.indexOf(split[i], offset-child.getBegin());
								AttributeDefinition attr = new AttributeDefinition(split[i],begin,begin+split[i].length());
								addRange(presentation, begin, split[i].length(), (TextAttribute) scanner.attributeToken.getData());
								for(int j=0;j<child.floating.size();j++){
									if(child.floating.get(j).getName().equals(split[i])){
										addRange(presentation, child.floating.get(j).getBegin()+child.getBegin(), split[i].length(), (TextAttribute) scanner.attributeToken.getData());
										attr.add(child.floating.remove(j));
										j--;
									}
								}
								child.add(attr);
							}
							else {
								boolean found = false;
								for(AttributeDefinition add:ad){
									if(child.getBegin()+add.getBegin()>=offset&&child.getBegin()+add.getEnd()<=offset+length){
										found = true;
										break;
									}
								}
								if(!found){
									String scopeString = document.get(child.getBegin(),child.getEnd()-child.getBegin());
									int begin = scopeString.indexOf(split[i], offset-child.getBegin());
									ad.add(new AttributeDefinition(split[i],begin,begin+split[i].length()));
									addRange(presentation, begin, split[i].length(), (TextAttribute) scanner.attributeToken.getData());
								}
							}
						}
					}
					if(ad==null){
						for(int i=0;i<split.length;i++){
							for(int k=0;k<split[i].length();k++){
								String regex = "";
								for(int j=0;j<split[i].length();j++){
									regex+=split[i].charAt(j);
									if(j==k){
										regex+=".?";
									}
								}
								ad=child.getAttribute(regex);
								if(ad!=null){
									if(i>0&&split[i-1].matches("[a-zA-Z]([a-zA-Z0-9_-]|<.*>)*\\[?\\]?")){
										addRange(presentation, ad.getBegin()+child.getBegin(), ad.getName().length(), (TextAttribute) scanner.defaultToken.getData());
										for(AttributeDefinition add:ad){
											addRange(presentation, add.getBegin()+child.getBegin(), add.getName().length(), (TextAttribute) scanner.defaultToken.getData());
										}
										child.floating.add(ad);
										ad = null;
									}
									else {
										regions.add(new TypedRegion(ad.getBegin()+child.getBegin(), split[i].length(), IDocument.DEFAULT_CONTENT_TYPE));
									}
								}
							}
						}
					}
					if(ad==null) {*/
				if(child!=null){
				child.clear();
				scanner.currentScope = child;
				if(child.getEnd()!=null){
					fScanner.setRange(document, child.getBegin(), (child.getEnd()-child.getBegin()-1)>3000?3000:(child.getEnd()-child.getBegin()-1));
				}
				else {
					fScanner.setRange(document, child.getBegin(), (document.getLength()-child.getBegin()-1)>3000?3000:(document.getLength()-child.getBegin()-1));
				}
				}
						//regions.add(new TypedRegion(child.getBegin(), child.getEnd()-child.getBegin(), IDocument.DEFAULT_CONTENT_TYPE));
						//break;
					/*}

				} catch (BadLocationException e) {
				}*/
			}
		}
		if(child==null){
			fScanner.setRange(document, 0, document.getLength());
		}
	}
}
