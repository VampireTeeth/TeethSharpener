'''
Created on Sep 28, 2012

@author: steven
'''

from django.conf.urls import url, patterns

urlpatterns = patterns('books.views',
                       url(r'^$', 'index'),
                       url(r'^search/$', 'search'),
                       url(r'^contact/$', 'contact'),
                       url(r'^contact/thanks/$', 'thanks'),
                       url(r'^detail/(?P<book_id>\d+)/$', 'detail'),
                       )
