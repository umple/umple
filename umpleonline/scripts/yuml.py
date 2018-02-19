#!/usr/bin/python

from optparse import OptionParser
import urllib2, urllib
import codecs
import os, sys
import time

class Request():
    opts = None
    body = u""
    out = None
    
    API_BASE = u"http://yuml.me/diagram"
    
    
    def log(self, msg):
        if self.opts.v:
            print u"[yuml]", msg
        else:
            return
    
    def loadbody(self):
        f = self.opts.infile
        self.log(u'Loading from %s' % ('stdin' if f == '-' else f))
        if f == '-':
            self.body = sys.stdin.readlines()
        elif os.path.exists(f):
            self.body = [x.strip() for x in codecs.open(f, 'r', 'utf-8').readlines()]
        else:
            raise IOError(u"File %s not found" % f)
    
    def prepout(self):
        self.out = open(self.opts.outfile, 'w')
    
    def run(self):
        start = time.time()
        
        if not self.body:
            self.loadbody()
        
        if not self.out:
            self.prepout()
        
        opts = self.opts.style + (";scale:" + str(self.opts.scale) if self.opts.scale else '')
        url = u"%s/%s/%s/%s.%s" % (self.API_BASE, opts, self.opts.type, urllib.quote(u', '.join(self.body).encode('utf8')), self.opts.fmt)
        
        self.log(u'Requesting %s' % url)
        
        response = urllib2.urlopen(url).read()
        self.out.write(response)
        
        self.log(u'Done after %f seconds' % (time.time() - start))

if __name__ == '__main__':
    parser = OptionParser(usage="%prog [-i FILE] -o FILE", version="%prog 0.1")
    parser.add_option("-i", "--in", dest="infile", help="read yuml from FILE instead of stdin", metavar="FILE", default="-")
    parser.add_option("-o", "--out", dest="outfile", help="store output in FILE", metavar="FILE")
    parser.add_option("-f", "--format", dest="fmt", help="force format FMT", metavar="FMT", default="png", choices=['png', 'pdf', 'jpg'])
    parser.add_option("-t", "--type", dest="type", help="draw a TYPE diagram", metavar="TYPE", default="class", choices=['class', 'activity', 'usecase'])
    parser.add_option("-s", "--style", dest="style", help="use style STY", metavar="STY", default="scruffy", choices=['scruffy', 'boring', 'plain'])
    parser.add_option("--scale", dest="scale", help="scale output to percentage", metavar="PERCENT", type="int")
    parser.add_option("-v", "--verbose", dest="v", help="print some debug info", action="store_true", default=False)

    (options, args) = parser.parse_args()
    
    r = Request()
    r.opts = options
    r.run()