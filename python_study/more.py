#!/usr/bin/env python
'''
Created on 27/09/2012

@author: steven
'''

def more(text, numlines=15):
  lines = text.splitlines()
  while lines:
    chunk = lines[:numlines]
    lines = lines[numlines:]
    for line in chunk:
      print line 
    if lines and raw_input('More?') not in ['y', 'Y']: 
      break

if __name__ == '__main__':
  import sys
  text = open(sys.argv[1]).read()
  more(text, 10)