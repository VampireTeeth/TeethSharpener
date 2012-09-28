'''
Created on Sep 28, 2012

@author: steven
'''

from django.conf.urls import patterns, url

urlpatterns = patterns('formplay.views',
                       url(r'^meta/$', 'meta'),
                       url(r'^search/$', 'search'),
                       )