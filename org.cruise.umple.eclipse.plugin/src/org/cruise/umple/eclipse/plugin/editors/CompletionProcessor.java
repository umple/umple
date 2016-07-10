package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.contentassist.*;



public class CompletionProcessor implements IContentAssistProcessor {

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		ICompletionProposal[] result= new ICompletionProposal[Parser.KEYWORDS.length];
		for (int i= 0; i < Parser.KEYWORDS.length; i++) {
//			IContextInformation info= new ContextInformation(Parser.KEYWORDS[i], MessageFormat.format("CompletionProcessor.Proposal.ContextInfo.pattern", new Object[] { Parser.KEYWORDS[i] })); //$NON-NLS-1$
//			result[i]= new CompletionProposal(Parser.KEYWORDS[i], offset, 0, Parser.KEYWORDS[i].length(), null, Parser.KEYWORDS[i], info, MessageFormat.format("CompletionProcessor.Proposal.hoverinfo.pattern", new Object[] { Parser.KEYWORDS[i]})); //$NON-NLS-1$
			IContextInformation info= new ContextInformation(Parser.KEYWORDS[i], ""); //$NON-NLS-1$
			result[i]= new CompletionProposal(Parser.KEYWORDS[i], offset, 0, Parser.KEYWORDS[i].length(), null, Parser.KEYWORDS[i], info, ""); //$NON-NLS-1$
		}
		return result;
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private final IContextInformation[] NO_CONTEXTS = { };
//    private final char[] PROPOSAL_ACTIVATION_CHARS = { 's','f','p','n','m', };
//    private ICompletionProposal[] NO_COMPLETIONS = { };
  
//    @Override
//    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
//    	try {
//            IDocument document = viewer.getDocument();
//            ArrayList result = new ArrayList();
//            String prefix = "";//lastWord(document, offset);
//            System.out.println(prefix);
//            String indent ="";// lastIndent(document, offset);
//            System.out.println(indent);
//            EscriptModel model = EscriptModel.getModel(document, null);
//            model.getContentProposals(prefix, indent, offset, result);  
//            System.out.println(result);
//            return (ICompletionProposal[]) result.toArray(new ICompletionProposal[result.size()]);
//         } catch (Exception e) {
//            // ... log the exception ...
//            return NO_COMPLETIONS;
//         }
//    }
    	
//	private String lastWord(IDocument doc, int offset) {
//        try {
//           for (int n = offset-1; n >= 0; n--) {
//             char c = doc.getChar(n);
//             if (!Character.isJavaIdentifierPart(c))
//               return doc.get(n + 1, offset-n-1);
//           }
//        } catch (BadLocationException e) {
//           // ... log the exception ...
//        }
//        return "";
//     }
//	private String lastIndent(IDocument doc, int offset) {
//        try {
//           int start = offset-1; 
//           while (start >= 0 && doc.getChar(start)!= '\n') start--;
//           int end = start;
//           while (end < offset && Character.isSpaceChar(doc.getChar(end))) end++;
//           return doc.get(start+1, end-start-1);
//        } catch (BadLocationException e) {
//           e.printStackTrace();
//        }
//        return "";
//     }
//	@Override
//	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
//		return NO_CONTEXTS;
//	}
//	
//	@Override
//	public char[] getCompletionProposalAutoActivationCharacters() {
//		return PROPOSAL_ACTIVATION_CHARS;
//	}
//
}
