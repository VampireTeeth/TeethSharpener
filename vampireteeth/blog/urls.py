'''
Created on Sep 30, 2012

@author: steven
'''
from django.conf.urls import url, patterns

urlpatterns = patterns('blog.views',
                      url(r'^$', 'main'),
                      url(r'^(\d+)/$', 'post'),
                      url(r'^add-comment/(\d+)/$', 'add_comment'),
                      )