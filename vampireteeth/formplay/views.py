# Create your views here.

from django.shortcuts import render_to_response
from django.template import RequestContext

def meta(request):
  http_meta = request.META
#  for k, v in request.META.items():
#    if k.startswith('HTTP'):
#      http_meta[k] = v
  return render_to_response('formplay/meta.html',
                     {'meta' : http_meta})
  
def search(request):
  request_method = request.META.get('REQUEST_METHOD', 'GET')
  if request_method in ['GET', 'get']:
    return render_to_response('formplay/search_form.html', context_instance=RequestContext(request))
  elif request_method in ['POST', 'post']:
    pass