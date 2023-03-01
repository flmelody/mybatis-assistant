package org.flmelody.mybatis.locator;

import com.google.common.collect.Sets;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import org.flmelody.mybatis.dom.model.Mapper;
import org.flmelody.mybatis.util.MapperUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Mapper xml package provider.
 *
 * @author yanglin
 */
public class MapperXmlPackageProvider extends PackageProvider {

    @NotNull
    @Override
    public Set<PsiPackage> getPackages(@NotNull Project project) {
        HashSet<PsiPackage> res = Sets.newHashSet();
        Collection<Mapper> mappers = MapperUtils.findMappers(project);
        JavaPsiFacade javaPsiFacade = JavaPsiFacade.getInstance(project);
        for (Mapper mapper : mappers) {
            String namespace = MapperUtils.getNamespace(mapper);
            PsiClass clazz = javaPsiFacade.findClass(namespace, GlobalSearchScope.allScope(project));
            if (null != clazz) {
                PsiFile file = clazz.getContainingFile();
                if (file instanceof PsiJavaFile) {
                    String packageName = ((PsiJavaFile) file).getPackageName();
                    PsiPackage pkg = javaPsiFacade.findPackage(packageName);
                    if (null != pkg) {
                        res.add(pkg);
                    }
                }
            }
        }
        return res;
    }

}
