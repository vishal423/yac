# YAC
Yet Another Codegen

## YAC Configuration

YAC CLI supports application configuration in `yaml` format. Refer below example to generate `Spring Boot` application using `Maven` as build tool:

```yaml
!application
name: YacBlog
application: !spring
  rootPackage: 'tech.yac.samples'
  buildTool: !maven
    wrapper: true
```
