# on jaxb annotations

http://blog.bdoughan.com/2011/06/using-jaxbs-xmlaccessortype-to.html

There might be a more efficient way to annotate these classes

Finally, when I refactor this to use lombok, use this
http://stackoverflow.com/questions/3665924/java-getter-setter-generation-with-lombok-for-code-with-annotations

We want to annotate on the fields for this badboy, not on the methods.

Then we can eliminate a whole lot of boilerplate.