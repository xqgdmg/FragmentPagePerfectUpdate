# FragmentPagePerfectUpdate
这是通过改变Fragment的集合来实现ViewPager里面的Fragment，以前试过直接这样做，但是发现不行，因为它会记住上一次的Fragment，直接通过集合来改变一般是不可以的，需要自己做一些处理。（主要是在instantiateItem处理）里面还有关于FragmentPagerAdapter的一些代码，用来自己看看。
