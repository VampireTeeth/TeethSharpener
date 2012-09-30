# Create your views here.
from blog.models import Post, Comment
from django.core.paginator import Paginator, InvalidPage, EmptyPage
from django.shortcuts import render_to_response, get_object_or_404
from django.contrib import admin
from django.forms.models import ModelForm
from django.http import HttpResponseRedirect
from django.core.urlresolvers import reverse
from django.core.context_processors import csrf
from django.template.context import RequestContext



blog_templates = 'blog/'

def main(request):
  '''Main listing.'''
  posts = Post.objects.all().order_by('-created')
  paginator = Paginator(posts, 2)
  
  
  try:
    page = int(request.GET.get('page', '1'))
  except ValueError:
    page = 1
    
  try:
    posts = paginator.page(page)
  except (InvalidPage, EmptyPage):
    posts = paginator.page(paginator.num_pages)
  
  return render_to_response(blog_templates+'list.html',
                            {'posts' : posts, 
                             'user' : request.user})
  
def post(request, pk):
  """Single post with comments and comment form"""
  post = get_object_or_404(Post, pk=pk)
  comments = post.comment_set.all().order_by("created")
  d = dict(post=post, user=request.user, comments=comments, form=CommentForm())
  return render_to_response(blog_templates+'post.html', d, 
                            context_instance=RequestContext(request))


class CommentForm(ModelForm):
  class Meta:
    model = Comment
    exclude = ["post"]

def add_comment(request, pk):
  """Add a new comment to a given post"""
  p = request.POST
  
  if p.has_key('body') and p['body']:
    author = p.get('author', 'Anonymous')
    
    comment = Comment(post=get_object_or_404(Post, pk=pk))
    cf = CommentForm(p, instance=comment)
    cf.fields["author"].required = False
    
    comment = cf.save(commit=False)
    comment.author = author
    comment.save()
  return HttpResponseRedirect(reverse(post, args=(pk,)))
    
  